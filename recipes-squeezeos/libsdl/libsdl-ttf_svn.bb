DESCRIPTION = "SDL TTF library"
SECTION = "libs"
LICENSE = "LGPL"

LIC_FILES_CHKSUM="file://COPYING;md5=27818cd7fd83877a8e3ef82b82798ef4"

BV = "2.0.8"

SRCREV = "9704"
PV = "${BV}+svnr${SRCREV}"
PR = "r2"

DEPENDS = "libsdl freetype"
RDEPENDS = "libsdl freetype"

# SDL has the hottest functions in the system, and Thumb is much slower for these
ARM_INSTRUCTION_SET = "arm"

SRC_URI="${SQUEEZEPLAY_SCM};module=SDL_ttf-${BV} \
	file://SDL_ttf-no-internals.patch;patch=1"

S = "${WORKDIR}/SDL_ttf-${BV}"

inherit autotools

autotools_do_configure() {
	${S}/autogen.sh
	oe_runconf
}

do_install_append() {
    rm ${D}/${libdir}/libSDL_ttf.la
}