DESCRIPTION = "Calaos Web GUI"
HOMEPAGE = "http://www.calaos.fr"

PR = "r1"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
SRC_URI[md5sum] = "1face50ead0790d1297dfb04bacf273c"
SRC_URI[sha256sum] = "89bcbf54f75f030a402a170ccc5286284999dc29"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/calaos/calaos_web.git;branch=new-gen;protocol=git"

S = "${WORKDIR}/git"

inherit systemd

do_install() {
    install -d ${D}/www/pages/
    cp -a ${WORKDIR}/git/* ${D}/www/pages/
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/calaos-config-update.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/calaos-config-update.path ${D}${systemd_unitdir}/system
}

FILES_${PN} += "/www/pages"
PACKAGE_ARCH = "all"


RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE = "calaos-config-update.service calaos-config-update.path"
