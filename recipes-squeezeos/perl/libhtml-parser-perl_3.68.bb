DESCRIPTION = "HTML Parser bits."
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r4"

LIC_FILES_CHKSUM = "file://README;md5=41c63ed3507c434404cf2d57c14960a6"

RDEPENDS_${PN} = "perl-module-test-more \
            perl-module-xsloader \
            perl-module-test-simple \
            libhtml-tagset-perl"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/HTML-Parser-${PV}.tar.gz"

S = "${WORKDIR}/HTML-Parser-${PV}"

SRC_URI[md5sum] = "5550b2da7aa94341f1e8a17a4ac20c68"
SRC_URI[sha256sum] = "430e852cd4e6c5f178e7d60f05fc17419de7cf3192d5ed75df01c47d318e16c2"

inherit cpan

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/HTML/Parser/.debug/"

BBCLASSEXTEND="native"

