FILESEXTRAPATHS := "${THISDIR}/${PN}"

PRINC := "${@int(PRINC) + 5}"

inherit systemd

SRC_URI += "file://lighttpd.service \
            file://lighttpd.conf"

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE = "lighttpd.service"

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
