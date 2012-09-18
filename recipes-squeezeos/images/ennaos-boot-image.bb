DESCRIPTION = "Enna OS - minimal bootable image"
PACKAGE_ARCH = "${MACHINE_ARCH}"
DEPENDS = "virtual/kernel"
PR = "r1"

inherit image

IMAGE_INSTALL = "task-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
