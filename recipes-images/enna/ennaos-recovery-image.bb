DESCRIPTION = "Enna OS - recovery image"

require ennaos-base-image.bb

# nand-part tool for A10 patitionning MBR
IMAGE_INSTALL += " sunxi-tools "

IMAGE_INSTALL += " enna-recovery "

export IMAGE_BASENAME = "ennaos-recovery-image"