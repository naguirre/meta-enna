DESCRIPTION = "A library of C++ classes for flexible logging to files, syslog, IDSA and other destinations."
HOMEPAGE = "http://sourceforge.net/projects/log4cpp/"
PRIORITY = "optional"
PR = "r0"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
SRC_URI[md5sum] = "d5b6de44f7f9ca0e4cefe597d1905605"
SRC_URI[sha256sum] = "3b66cb76d9bc7da80ef1f271cc29d3a183b5ff8b560ef60e85ff006bffb4d1ae"
SRC_URI = "http://downloads.sourceforge.net/project/${PN}/${PN}/0.9/libvmime-0.9.1.tar.bz2"
S = "${WORKDIR}/libvmime-0.9.1"
inherit autotools pkgconfig

EXTRA_OECONF = "--disable-sasl"

do_configure_prepend() {
    ./bootstrap
}


