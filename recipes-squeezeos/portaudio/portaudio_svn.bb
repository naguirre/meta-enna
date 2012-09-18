DESCRIPTION = "Portaudio"
LICENSE = "portaudio"

BV = "v19_1360"

PV = "${BV}+svnr${SRCREV}"
PR = "r1"

DEPENDS = "alsa-lib"

SRC_URI="${SQUEEZEPLAY_SCM};module=portaudio_${BV}"

S = "${WORKDIR}/portaudio_${BV}"

inherit autotools

EXTRA_OECONF = "--without-jack --without-oss"
