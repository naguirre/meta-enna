DESCRIPTION = "HTML Parser bits."
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r3"

LIC_FILES_CHKSUM = "file://README;md5=41c63ed3507c434404cf2d57c14960a6"

RDEPENDS_${PN} = "perl-module-test-more \
            perl-module-xsloader \
            perl-module-test-simple \
            libhtml-tagset-perl"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/HTML-Parser-${PV}.tar.gz"

S = "${WORKDIR}/HTML-Parser-${PV}"

SRC_URI[md5sum] = "26ceb6357e855b9e7aad5a5fd66d493e"
SRC_URI[sha256sum] = "7e5396568c9cf12e773802c80507b7dac1bd4635e2c6a052bd994fe62638271a"

inherit cpan

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/HTML/Parser/.debug/"

BBCLASSEXTEND="native"

