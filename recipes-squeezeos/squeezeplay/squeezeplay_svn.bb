DESCRIPTION = "SqueezePlay"
LICENSE = "Logitech Public Source License"

SRCREV = "9704"
LIC_FILES_CHKSUM="file://LICENSE;md5=0c32b78019be064aeb5ec5c5f1eb0586"

PV = "${DISTRO_VERSION}+svnr${SRCREV}"
PR = "r25"

DEPENDS += "libsdl libsdl-ttf libsdl-gfx libsdl-image"
DEPENDS += "lua5.1 lua5.1-native luatolua++"
DEPENDS += "flac libmad tremor"

SRC_URI = "${SQUEEZEPLAY_SCM};module=squeezeplay \
        file://jive_no_display.patch \
        file://comment_pcm_hw_params_set_periods.patch \
	file://logconf.lua \
        file://jive.service \
        file://jive.sh"

S = "${WORKDIR}/squeezeplay"

ARM_INSTRUCTION_SET = "arm"

inherit autotools systemd

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE = "jive.service"

EXTRA_OECONF = "--disable-portaudio --enable-fsync-workaround"

EXTRA_OECONF_append_baby = " --enable-screen-rotation"

# Optional close source package
DEPENDS += "${@base_conditional('ENABLE_SPPRIVATE', 'yes', 'squeezeplay-private', '', d)}"
EXTRA_OECONF += "${@base_conditional('ENABLE_SPPRIVATE', 'yes', '--with-spprivate', '', d)}"

CFLAGS_prepend = '-DSQUEEZEPLAY_RELEASE=\\"${SQUEEZEOS_DISTRO_RELEASE}\\" -DSQUEEZEPLAY_REVISION=\\"${SQUEEZEOS_SQUEEZEPLAY_REVISION}\\"'

EXTRA_OEMAKE = "all lua-lint"

do_install_append() {
	install -m 0644 ${WORKDIR}/logconf.lua ${D}${datadir}/jive/logconf.lua
        mkdir -p  ${D}${includedir}/squeezeplay/ui
        install -m 0644 ${S}/src/ui/*.h ${D}${includedir}/squeezeplay/ui
        install -m 0644 ${S}/src/*.h ${D}${includedir}/squeezeplay
        install -m 0755 ${WORKDIR}/jive.sh ${D}/${bindir}
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/jive.service ${D}${systemd_unitdir}/system
}

PACKAGES += "${PN}-qvgaskin ${PN}-jiveskin ${PN}-fab4skin ${PN}-babyskin"

FILES_${PN}-qvgaskin = "\
	${datadir}/jive/applets/QVGAbaseSkin/* \
"

FILES_${PN}-jiveskin = "\
	${datadir}/jive/applets/QVGAportraitSkin/* \
"

FILES_${PN}-babyskin = "\
	${datadir}/jive/applets/QVGAlandscapeSkin/* \
"

FILES_${PN}-fab4skin = "\
	${datadir}/jive/applets/WQVGAlargeSkin/* \
	${datadir}/jive/applets/WQVGAsmallSkin/* \
"

FILES_${PN} += "\
	${datadir} \
        $[bindir}/jive.sh \
"
