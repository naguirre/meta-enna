PRINC = "1"

FILESEXTRAPATHS := "${THISDIR}/files"

ENNA_VERSION = "v1"
ENNA_CODENAME = "calliope"
ENNA_DATE = "`date +%m-%d-%Y`"
ENNA_DESCRIPTION = "EnnaOS ${ENNA_VERSION} ${CODENAME}"

SRC_URI = "file://lsb_release"

do_install() {
	install -d ${D}${sysconfdir}
	echo "ennaos" > ${D}${sysconfdir}/enna-version
        echo "${ENNA_CODENAME}" >> ${D}${sysconfdir}/enna-version
        echo "${ENNA_VERSION}" >> ${D}${sysconfdir}/enna-version
        echo "${ENNA_DATE}" >> ${D}${sysconfdir}/enna-version

	echo "NAME=ennaos" > ${D}${sysconfdir}/os-release
	echo "ID=ennaos" >> ${D}${sysconfdir}/os-release
	echo "PRETTY_NAME=${ENNA_DESCRIPTION}" >> ${D}${sysconfdir}/os-release
	echo "ANSI_COLOR=1;34" >> ${D}${sysconfdir}/os-release
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/lsb_release ${D}${bindir}/
}