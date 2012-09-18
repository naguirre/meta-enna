DESCRIPTION = "Enna OS - base image"

require ennaos-boot-image.bb

IMAGE_INSTALL += "squeezeplay squeezeplay-squeezeos"
IMAGE_INSTALL += "watchdog"

# wireless tools
#IMAGE_INSTALL += "wireless-tools"

# useful command line tools
IMAGE_INSTALL += "alsa-utils-aplay alsa-utils-amixer"

# Simple NTP client
IMAGE_INSTALL += "msntp"
