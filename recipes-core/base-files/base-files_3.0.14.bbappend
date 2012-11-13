
FILESEXTRAPATHS := "${THISDIR}/${PN}"

PRINC = "6"

SRC_URI_append = " file://var-run.conf \
                   file://modules.conf \
                   file://machine-id \
                   file://linuxrc \
                 "

dirs755 += "/run /media /media/storage /media/overlay /media/overlay/dev /media/overlay/sys /media/overlay/proc"

# links to volatile for readonly RFS
do_install_append () {
		install -d ${D}${sysconfdir}/tmpfiles.d
		install -m 0644 ${WORKDIR}/var-run.conf ${D}${sysconfdir}/tmpfiles.d/
                install -d ${D}${sysconfdir}/modules-load.d
		install -m 0644 ${WORKDIR}/modules.conf ${D}${sysconfdir}/modules-load.d
                install -m 0755 ${WORKDIR}/linuxrc ${D}/
                cp ${WORKDIR}/machine-id ${D}${sysconfdir}

}
