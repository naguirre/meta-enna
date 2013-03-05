DESCRIPTION = "Lightweight high-performance web server"
HOMEPAGE = "http://www.lighttpd.net/"
BUGTRACKER = "http://redmine.lighttpd.net/projects/lighttpd/issues"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=e4dac5c6ab169aa212feb5028853a579"

SECTION = "net"
DEPENDS = "zlib libpcre openssl"
RDEPENDS_${PN} += " \
               lighttpd-module-access \
               lighttpd-module-accesslog \
               lighttpd-module-indexfile \
               lighttpd-module-dirlisting \
               lighttpd-module-staticfile \
"

PR = "r1"

SRC_URI = "http://download.lighttpd.net/lighttpd/releases-1.4.x/lighttpd-${PV}.tar.xz \
	file://lighttpd.service \
	file://lighttpd.conf \
        "
SRC_URI[md5sum] = "e5a6f57fc371a10646ff1a57056fa9c0"
SRC_URI[sha256sum] = "1368f80069ce71f5928cad59c8e60c0b95876942ca9e02c53853e54ae24aedc1"

EXTRA_OECONF = " \
             --without-bzip2 \
             --without-ldap \
             --without-lua \
             --without-memcache \
             --with-pcre \
             --without-webdav-props \
             --without-webdav-locks \
             --with-openssl \
             --disable-static \
"
inherit autotools pkgconfig gettext systemd

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE = "lighttpd.service"

do_install_append() {
    install -d ${D}${sysconfdir}
    install -d ${D}/www/logs ${D}/www/pages/dav ${D}/www/var
    install -m 0755 ${WORKDIR}/lighttpd.conf ${D}${sysconfdir}
}

FILES_${PN} += "${sysconfdir} /www"

CONFFILES_${PN} = "${sysconfdir}/lighttpd.conf"

PACKAGES_DYNAMIC = "lighttpd-module-*"

python populate_packages_prepend () {
    lighttpd_libdir = d.expand('${libdir}')
    do_split_packages(d, lighttpd_libdir, '^mod_(.*)\.so$', 'lighttpd-module-%s', 'Lighttpd module for %s', extra_depends='')
}
