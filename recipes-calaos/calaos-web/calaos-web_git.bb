DESCRIPTION = "Calaos Web GUI"
HOMEPAGE = "http://www.calaos.fr"

PR = "r0"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
SRC_URI[md5sum] = "1face50ead0790d1297dfb04bacf273c"
SRC_URI[sha256sum] = "89bcbf54f75f030a402a170ccc5286284999dc29"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/calaos/calaos_web.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/www/pages/
    cp -a ${WORKDIR}/git/* ${D}/www/pages/
}

FILES_${PN} += "/www/pages"
PACKAGE_ARCH = "all"



