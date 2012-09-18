
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC = "1"

SRC_URI += "file://squeezeos_compat.diff"

EXTRA_OECONF = "--enable-audio --enable-video --enable-events --disable-joystick --disable-cdrom --enable-threads -enable-timers --enable-file --enable-loadso --disable-oss --disable-alsa --disable-esd --disable-arts --disable-video-x11 --disable-video-directfb --enable-clock_gettime"