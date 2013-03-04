DESCRIPTION = "E17 configuration for calaos"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

DEPENDS = "edje-native eet-native e-wm"

PACKAGES_DYNAMIC = "e-wm-config-calaos*"

PR = "r0"

SRC_URI = " \
          file://configs \
          "
S = "${WORKDIR}/configs"

do_compile() {
rm ${S}/patches -rf
for dir in ${S}/* ; do	
	cd $dir
	for i in *.src ; do
		eet -e $(echo $i | sed s:src:cfg:g) config $i 1
	done
done
}

do_install() {
 	for i in ${WORKDIR}/configs/* ; do
		install -d ${D}${datadir}/enlightenment/data/config/$(basename $i)/
    
		install -m 0644 ${S}/$(basename $i)/*.cfg ${D}${datadir}/enlightenment/data/config/$(basename $i)/
		install -m 0644 ${S}/$(basename $i)/*.desktop ${D}${datadir}/enlightenment/data/config/$(basename $i)/
		install -m 0644 ${S}/$(basename $i)/*.png ${D}${datadir}/enlightenment/data/config/$(basename $i)/
	done
}

RDEPENDS_${PN} = "e-wm"

python populate_packages_prepend () {
    angstrom_e_dir = bb.data.expand('${datadir}/enlightenment/data/config', d)
    do_split_packages(d, angstrom_e_dir, '(.*)', 'e-wm-config-%s', 'E17 window manager %s config', extra_depends='e-wm', allow_links=True, allow_dirs=True)
}

PACKAGE_ARCH = "all"

