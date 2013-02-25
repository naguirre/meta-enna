DESCRIPTION = "SqueezePlay NOGUI"
LICENSE = "Logitech Public Source License"

PV = "${DISTRO_VERSION}+svnr${SRCREV}"
PR = "r26"

SRCREV = "9704"
LIC_FILES_CHKSUM="file://LICENSE;md5=0c32b78019be064aeb5ec5c5f1eb0586"

require squeezeplay.inc

SRC_URI = "${SQUEEZEPLAY_SCM};module=squeezeplay \
        file://jive_no_display.patch \
        file://comment_pcm_hw_params_set_periods.patch \
	file://logconf.lua \
        file://jive.service \
        file://jive.sh"
