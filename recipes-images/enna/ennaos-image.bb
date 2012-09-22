DESCRIPTION = "Enna OS - base image"

DEPENDS = "virtual/kernel"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

IMAGE_LINGUAS = " "

require systemd-image.bb

LICENSE = "MIT"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_INSTALL += " squeezeplay squeezeplay-squeezeos squeezeplay-desktop dropbear iputils "
IMAGE_INSTALL += " watchdog "
IMAGE_INSTALL += " shairport "
IMAGE_INSTALL += " task-base-extended "
IMAGE_INSTALL += " lighttpd "

# wireless tools
IMAGE_INSTALL += "wireless-tools"

# mtd and ubi tools
IMAGE_INSTALL += " mtd-utils "

# useful command line tools
IMAGE_INSTALL += "alsa-utils-aplay alsa-utils-amixer"

# Simple NTP client
IMAGE_INSTALL += "msntp"

export IMAGE_BASENAME = "ennaos-image"