DESCRIPTION = "Transmission is a BitTorrent client with a built-in Ajax-Powered Webif GUI."
SECTION = "network"
HOMEPAGE = "www.transmissionbt.com"
DEPENDS = "gnutls openssl gettext libtool intltool-native curl libevent glib-2.0-native"
LICENSE = "GPLv2"
INC_PR = "r1"
SRC_URI = "http://download-origin.transmissionbt.com/files/transmission-${PV}.tar.xz"

LIC_FILES_CHKSUM="file://COPYING;md5=7ee657ac1dce0e7353033fc06c8087d2"

inherit autotools

EXTRA_OECONF = "--disable-nls --enable-lightweight --disable-gtk"

do_configure() {
    autoreconf -vif
    oe_runconf
}

PACKAGES = "${PN}-cli ${PN}-daemon ${PN}-web ${PN}-dbg ${PN}-daemon-doc ${PN}-cli-doc"

FILES_${PN}-daemon = "${bindir}/transmission-daemon"

FILES_${PN}-cli = "${bindir}/transmission-cli \
                   ${bindir}/transmission-create \
		   ${bindir}/transmission-edit \
		   ${bindir}/transmission-remote \
		   ${bindir}/transmission-store \
		   ${bindir}/transmission-show"

FILES_${PN}-web = "${datadir}/transmission/web/"

FILES_${PN}-dbg = "/usr/src/debug/ /usr/bin/.debug"

FILES_${PN}-daemon-doc = "/usr/share/man/man1/transmission-daemon.1"

FILES_${PN}-cli-doc = "/usr/share/man/man1/transmission-show.1 \
		       /usr/share/man/man1/transmission-edit.1\
		       /usr/share/man/man1/transmission-create.1 \
		       /usr/share/man/man1/transmission-remote.1 \
		       /usr/share/man/man1/transmission-cli.1"
