DESCRIPTION = "Enna box web config"
HOMEPAGE = "http://enna.me"

PR = "r2"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://README.md;md5=62cba4388876235130952fc84a5389ce"
SRC_URI[md5sum] = "1face50ead0790d1297dfb04bacf273c"
SRC_URI[sha256sum] = "89bcbf54f75f030a402a170ccc5286284999dc29"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/raoulh/www-enna.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/www/pages
    install -d ${D}/www/pages/css
    install -d ${D}/www/pages/img
    install -d ${D}/www/pages/js
    install -m 0644 ${S}/*.php ${D}/www/pages
    install -m 0644 ${S}/css/*.css ${D}/www/pages/css
    install -m 0644 ${S}/img/* ${D}/www/pages/img
    install -m 0644 ${S}/js/*.js ${D}/www/pages/js
    sed -i 's/raoul/root/' ${D}/www/pages/common.php
}
FILES_${PN} += "/www/pages"
PACKAGE_ARCH = "all"



