DESCRIPTION = "Enna OS - base image"

DEPENDS = "virtual/kernel"
PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_INSTALL += " squeezeplay squeezeplay-desktop"
IMAGE_INSTALL += " watchdog "
IMAGE_INSTALL += " shairport "
IMAGE_INSTALL += " lighttpd lighttpd-module-fastcgi"
IMAGE_INSTALL += " avahi avahi-daemon avahi-systemd avahi-utils "
IMAGE_INSTALL += " php-cli php-cgi "
IMAGE_INSTALL += " www-enna "

# wireless tools
IMAGE_INSTALL += "wireless-tools"

# network utils
IMAGE_INSTALL += " iputils dropbear "

# mtd and ubi tools
IMAGE_INSTALL += " mtd-utils "

# useful command line tools
IMAGE_INSTALL += "alsa-utils-aplay alsa-utils-amixer"

# Simple NTP client
IMAGE_INSTALL += "msntp"

IMAGE_INSTALL += " kernel-modules "

IMAGE_INSTALL += " liblzma "

require systemd-image.bb

hostname = "enna-box"

export IMAGE_BASENAME = "ennaos-image"