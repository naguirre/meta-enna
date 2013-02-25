
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC = "1"

SRC_URI += "file://squeezeos_compat.diff"

EXTRA_OECONF = "--enable-audio --enable-video --enable-events --disable-joystick --disable-cdrom --enable-threads -enable-timers --enable-file --enable-loadso --disable-oss --disable-alsa --disable-esd --disable-arts --enable-clock_gettime \
                ${@base_contains('DISTRO_FEATURES', 'directfb', '--enable-video-directfb', '--disable-video-directfb', d)} \
                ${@base_contains('DISTRO_FEATURES', 'opengl', '--enable-video-opengl', '--disable-video-opengl', d)} \
                ${@base_contains('DISTRO_FEATURES', 'x11', '--enable-video-x11', '--disable-video-x11', d)} \
"


do_install_append() {
    rm ${D}/${libdir}/libSDL.la
}
