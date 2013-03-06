FILESEXTRAPATHS := "${THISDIR}/${PN}"

FEED_BASEPATH = ""
ANGSTROM_URI = "http://82.227.130.131/enna-os/"

do_compile() {
	mkdir -p ${S}/${sysconfdir}/opkg

        echo "src/gz base ${ANGSTROM_URI}/${FEED_BASEPATH}${FEED_ARCH}/" > ${S}/${sysconfdir}/opkg/base-feed.conf
	echo "src/gz ${MACHINE_ARCH} ${ANGSTROM_URI}/${FEED_BASEPATH}/${MACHINE_ARCH}" >  ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf
	echo "#src/gz sdk ${ANGSTROM_URI}/${FEED_BASEPATH}sdk" > ${S}/${sysconfdir}/opkg/sdk-feed.conf
	echo "src/gz no-arch ${ANGSTROM_URI}/${FEED_BASEPATH}all" > ${S}/${sysconfdir}/opkg/noarch-feed.conf
		
	# iwmmxt is a special case, add the iwmmxt feed for machine that have 'iwmmxt' in MACHINE_FEATURES
	if [ "${IWMMXT_FEED}" = "iwmmxt" ] ; then
	   echo "src/gz iwmmxt ${ANGSTROM_URI}/${FEED_BASEPATH}iwmmxt/base" > ${S}/${sysconfdir}/opkg/iwmmxt-feed.conf
	fi  
}


PRINC := "${@int(PRINC) + 3}"

FILES_${PN} = "${sysconfdir}/opkg/base-feed.conf \
               ${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf \
               ${sysconfdir}/opkg/noarch-feed.conf \
               ${sysconfdir}/opkg/sdk-feed.conf \
              "

CONFFILES_${PN} = "${sysconfdir}/opkg/base-feed.conf \
                   ${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf \
                   ${sysconfdir}/opkg/noarch-feed.conf \
                   ${sysconfdir}/opkg/sdk-feed.conf \
                  "

python populate_packages_prepend () {
}
