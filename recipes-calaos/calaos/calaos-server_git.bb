DESCRIPTION = "Calaos Server"
HOMEPAGE = "http://www.calaos.fr"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PR = "r10"

DEPENDS = "elementary libsigc++-2.0 owfs log4cpp libvmime jansson lua5.1"

SRCREV = "a5e53f528d311ec073dddbffdf012ada231dd538"
SECTION = "x11/multimedia"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/calaos/calaos_base.git;protocol=http;branch=master \
	file://calaos-server.service"

inherit autotools gettext systemd

do_configure_prepend() {
    autopoint || touch config.rpath
}

do_install_append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/calaos-server.service ${D}${systemd_unitdir}/system
}

FILES_${PN} = "${bindir}/calaos_server"


RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE = "${PN}.service"
