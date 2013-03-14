FILESEXTRAPATHS := "${THISDIR}/${PN}"

PRINC := "${@int(PRINC) + 1}"

SRC_URI += "file://uvesafb.conf"

do_install () {
	install -d ${D}${base_sbindir}
	install v86d ${D}${base_sbindir}/

	install -d ${D}${sysconfdir}/modules-load.d/
	install -m 0755 ${WORKDIR}/uvesafb.conf ${D}${sysconfdir}/modules-load.d/uvesafb.conf
}