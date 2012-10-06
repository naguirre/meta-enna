SUMMARY = "A daemon for managing internet connections within embedded devices"
DESCRIPTION = "The ConnMan project provides a daemon for managing \ 
internet connections within embedded devices running the Linux \
operating system.  The Connection Manager is designed to be slim and \
to use as few resources as possible, so it can be easily integrated. \
It is a fully modular system that can be extended, through plug-ins, \
to support all kinds of wired or wireless technologies. Also, \
configuration methods, like DHCP and domain name resolving, are \
implemented using plug-ins."
HOMEPAGE = "http://connman.net/"
BUGTRACKER = "http://bugs.meego.com/buglist.cgi?quicksearch=connman"
LICENSE  = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

# we need to define the depends here, the dynamic stuff is too late
DEPENDS  = "dbus glib-2.0 ppp iptables gnutls \
            ${@base_contains('DISTRO_FEATURES', 'bluetooth','bluez4', '', d)} \
            ${@base_contains('DISTRO_FEATURES', 'wifi','wpa-supplicant', '', d)} \
            ofono \
            python-dbus \
            python-pygobject \
            "

EXTRA_OECONF += "\
    ac_cv_path_WPASUPPLICANT=${sbindir}/wpa_supplicant \
    ac_cv_path_PPPD=${sbindir}/pppd \
    --disable-gtk-doc \
    --enable-debug \
    --enable-threads \
    --enable-loopback \
    --enable-ethernet \
    ${@base_contains('DISTRO_FEATURES', 'wifi','--enable-wifi', '--disable-wifi', d)} \
    ${@base_contains('DISTRO_FEATURES', 'bluetooth','--enable-bluetooth', '--disable-bluetooth', d)} \
    --enable-dnsproxy \
    --enable-ofono \
    --enable-tools \
    --enable-test \
    --disable-polkit \
    --enable-client \
    --enable-fake \
    --disable-ntpd \
    --with-systemdunitdir=${systemd_unitdir}/system/ \
"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --no-create-home \
                       --shell /bin/false --groups video,tty,audio \
                       --user-group xuser"

inherit autotools pkgconfig useradd

do_compile_append() {
	sed -i -e s:deny:allow:g src/connman-dbus.conf
}

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/tools/*-test ${D}${bindir}
	install -m 0755 ${S}/tools/wispr ${D}${bindir}
        install -m 0755 ${S}/client/connmanctl ${D}${bindir}
	# We don't need to package an empty directory
	rmdir ${D}${libdir}/connman/scripts
}
PACKAGES =+ "${PN}-tools ${PN}-tests connmanctl"

FILES_${PN}-tools = "${bindir}/wispr"

FILES_connmanctl = "${bindir}/connmanctl"

FILES_${PN}-tests = "${bindir}/*-test ${libdir}/${BPN}/test/*"
RDEPENDS_${PN}-tests = "python-dbus"

FILES_${PN} = "${bindir}/* ${sbindir}/* ${libexecdir}/* ${libdir}/lib*.so.* \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_bindir}/* ${base_sbindir}/* ${base_libdir}/*.so* ${datadir}/${PN} \
            ${datadir}/pixmaps ${datadir}/applications \
            ${datadir}/idl ${datadir}/omf ${datadir}/sounds \
            ${libdir}/bonobo/servers \
            ${datadir}/dbus-1/system-services/*"

FILES_${PN}-dbg += "${libdir}/connman/*/.debug"

FILES_${PN}-dev += "${libdir}/connman/*/*.la"
