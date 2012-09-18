SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "tremor is a low memory fixed point implementation of the vorbis codec."
LICENSE = "BSD"
##SRCDATE = "${PV}"
PR = "r3"
SRCREV = "9704"
LIC_FILES_CHKSUM="file://COPYING;md5=70da6b436ce820186becb157064398ae"

PV = "${DISTRO_VERSION}+svnr${SRCREV}"

SRC_URI = "${SQUEEZEPLAY_SCM};module=Tremor"

S = "${WORKDIR}/Tremor"

inherit autotools

EXTRA_OECONF=" --enable-shared --disable-rpath  "

CFLAGS_prepend = "-DSQUEEZEPLAY "

ARM_INSTRUCTION_SET = "arm"

