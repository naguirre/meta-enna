DESCRIPTION = "GIF Library"
HOMEPAGE = "http://sourceforge.net/projects/giflib/"
LICENSE = "giflib"
SECTION = "libs"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/giflib/giflib-${PV}.tar.bz2"

ARM_INSTRUCTION_SET = "arm"

inherit autotools

PACKAGES += "giflib-bin"
FILES_${PN} = "${libdir}/libgif.so.*"
FILES_giflib-bin = "${bindir}/*"

