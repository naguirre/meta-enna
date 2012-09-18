DESCRIPTION = "SqueezeOS - minimal bootable image"
PACKAGE_ARCH = "${MACHINE_ARCH}"
DEPENDS = "virtual/kernel"
PR = "r1"

inherit image

IMAGE_INSTALL += " \
	squeezeos-base-files \
	busybox \
	udev \
	mtd-utils"

IMAGE_LINGUAS = " "

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files"

# write squeezeos.version file
do_rootfs_prepend() {
	echo "${DISTRO_VERSION} ${DATETIME}" 

}

do_rm_work() {
	true
}
