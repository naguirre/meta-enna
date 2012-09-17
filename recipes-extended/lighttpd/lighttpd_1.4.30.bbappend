FILESEXTRAPATHS := "${THISDIR}/${PN}"

PRINC := "${@int(PRINC) + 4}"

inherit systemd

SRC_URI += "file://lighttpd.service"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "lighttpd.service"

EXTRA_OECONF = " \
             --without-bzip2 \
             --without-ldap \
             --without-lua \
             --without-memcache \
             --with-pcre \
             --without-webdav-props \
             --without-webdav-locks \
             --with-openssl \
             --disable-static \
"
