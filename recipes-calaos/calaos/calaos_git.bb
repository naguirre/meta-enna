DESCRIPTION = "Calaos"
SECTION = "x11/multimedia"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r4"
SRC_URI[md5sum] = "1face50ead0790d1297dfb04bacf273c"
SRC_URI[sha256sum] = "89bcbf54f75f030a402a170ccc5286284999dc29"

SRCREV = "${AUTOREV}"
DEPENDS = "elementary libsigc++-2.0 owfs log4cpp libvmime jansson lua5.1"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/calaos/calaos_base.git;protocol=http;branch=master \
	file://calaos-server.service"

inherit autotools gettext systemd

do_configure_prepend() {
    autopoint || touch config.rpath
}

PACKAGES = "${PN}-server ${PN}-home"

FILES_${PN}-server = "${bindir}/calaos_server"

FILES_${PN}-home = "${bindir}/calaos_home \
		 ${datadir}/calaos/* \
		 ${datadir}/locale/*"

SYSTEMD_PACKAGES = "calaos-server-systemd"
SYSTEMD_SERVICE_calaos-server-systemd = "calaos-server.service"
