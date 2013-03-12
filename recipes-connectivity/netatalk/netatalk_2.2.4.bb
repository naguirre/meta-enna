SECTION = "net"
PR = "r1"
LICENSE = "GPLv2"

SRC_URI = "http://iweb.dl.sourceforge.net/project/netatalk/netatalk/${PV}/netatalk-${PV}.tar.gz "

SRC_URI[md5sum] = "0a383e1f1a74ce3435244363808d3ed4"
SRC_URI[sha256sum] = "ef24882d6ef3da333fd09a14d5434a62b639c2b5fbfd781c65110db4cb3263f3"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

inherit autotools update-rc.d

DEPENDS = "cups db openssl"

INITSCRIPT_NAME = "atalk"
INITSCRIPT_PARAMS = "defaults 65"

PACKAGES = "${PN}-atalkd ${PN}-pap ${PN}-timelord ${PN}-dbg ${PN} ${PN}-doc ${PN}-dev"

RRECOMMENDS_${PN}-atalkd = "kernel-module-appletalk"

FILES_${PN}-atalkd += "${sysconfdir}/netatalk/atalkd.conf \
                       /usr/sbin/atalkd"
FILES_${PN}-pap +=  "/usr/bin/pap \
                     ${sysconfdir}/netatalk/papd.conf \
                     /usr/sbin/papd \
                     /usr/bin/papstatus"
FILES_${PN}-timelord += "/usr/sbin/timelord"
FILES_${PN}-dbg += "${sysconfdir}/netatalk/uams/.debug"
           
EXTRA_OECONF += "ac_cv_path_KRB5_CONFIG=no \
                 ac_cv_header_rpcsvc_rquota_h=no \
                 --with-bdb=${STAGING_DIR_TARGET}/usr \
                 --without-shadow \
                 --enable-static=no \
                 --disable-srvloc \
                 --without-pam \
                 --with-ssl-dir=${STAGING_DIR_TARGET}/usr"
LDFLAGS += "-lpthread -L${STAGING_LIBDIR}"

