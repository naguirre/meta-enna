DESCRIPTION = "Enna OS - image"

require systemd-image.bb

# wireless tools
IMAGE_INSTALL += "wireless-tools"

# network utils
IMAGE_INSTALL += " iputils dropbear connman-tools connman-tests"

# mtd and ubi tools
IMAGE_INSTALL += " mtd-utils dosfstools e2fsprogs-mke2fs"

# useful command line tools
IMAGE_INSTALL += "alsa-utils-aplay alsa-utils-amixer"

# Simple NTP client
IMAGE_INSTALL += "cronie cronie-systemd"

IMAGE_INSTALL += " kernel-modules "

IMAGE_INSTALL += " liblzma "



export IMAGE_BASENAME = "ennaos-base-image"
