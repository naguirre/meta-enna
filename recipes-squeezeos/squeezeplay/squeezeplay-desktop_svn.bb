DESCRIPTION = "SqueezePlay - Desktop specific code"
LICENSE = "CLOSED"

SRCREV = "9704"

PV = "${DISTRO_VERSION}+svnr${SRCREV}"
PR = "r2"

DEPENDS += "squeezeplay"

SRC_URI="${SQUEEZEPLAY_SCM};module=squeezeplay_desktop"

S = "${WORKDIR}/squeezeplay_desktop"

inherit autotools

CFLAGS_prepend = '-I${STAGING_INCDIR}/squeezeplay'

EXTRA_OEMAKE = "all"

# Optional close source package
DEPENDS += "${@base_conditional('ENABLE_SPPRIVATE', 'yes', 'squeezeplay-private', '', d)}"
EXTRA_OECONF += "${@base_conditional('ENABLE_SPPRIVATE', 'yes', '--with-spprivate', '', d)}"


do_install() {
	autotools_do_install
	mkdir -p ${D}${libdir}/lua/5.1
}


FILES_${PN} += "${datadir} ${libdir}/lua/5.1"
FILES_${PN}-dbg += "${libdir}/lua/5.1/.debug"
