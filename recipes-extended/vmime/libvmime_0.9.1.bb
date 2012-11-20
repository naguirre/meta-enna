DESCRIPTION = "VMime is a free mail library for C++"
HOMEPAGE = "http://www.vmime.org/"
DEPENDS = "gnutls "
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/vmime/${PN}-${PV}.tar.bz2"
SRC_URI[md5sum] = "d5b6de44f7f9ca0e4cefe597d1905605"
SRC_URI[sha256sum] = "3b66cb76d9bc7da80ef1f271cc29d3a183b5ff8b560ef60e85ff006bffb4d1ae"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

EXTRA_OECONF = "--disable-sasl"

do_configure_prepend () {
  ./bootstrap --disable-sasl
}

# Workaround for vmime which creates .pc inside install
do_install_append () {
  for i in `find ${S}/ ${D}/${libdir}/pkgconfig -name "*.pc" -type f` ; do \
    sed -i -e 's:${D}::g' $i
  done
}

inherit autotools pkgconfig
