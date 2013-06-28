DESCRIPTION = "Enna Mediacenter"
HOMEPAGE = "http://www.enna.tv"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=dafc9d229b65b58f253daf44ad9a821a"

PR = "r1"

DEPENDS = "elementary libvalhalla"

SRC_URI[md5sum] = "1face50ead0790d1297dfb04bacf273c"
SRC_URI[sha256sum] = "89bcbf54f75f030a402a170ccc5286284999dc29"

SRCREV = "${AUTOREV}"
SECTION = "x11/multimedia"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/enna-project/enna.git;protocol=http;branch=master"

inherit autotools gettext systemd update-alternatives

do_configure_prepend() {
    autopoint || touch config.rpath
}

FILES_${PN} = "${bindir}/enna \
	       ${datadir}/enna/* \
	       ${datadir}/locale/*"


ALTERNATIVE_${PN} = "x-window-manager"
ALTERNATIVE_TARGET[x-window-manager] = "${bindir}/enna"
ALTERNATIVE_PRIORITY[x-window-manager] = "10"