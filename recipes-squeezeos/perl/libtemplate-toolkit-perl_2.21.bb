DESCRIPTION = "Template - Front-end module to Template Toolkit"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

LIC_FILES_CHKSUM = "file://README;md5=d21e3dcbe75af8a505a7763bed87ce67"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AB/ABW/Template-Toolkit-${PV}.tar.gz"

SRC_URI[md5sum] = "0708d159250e760b6e82294211ad1dc1"
SRC_URI[sha256sum] = "9057c6b31db96895326d8ac17e5ebaa26ca661f5132bba2acc7c38a3df61e1ab"

S = "${WORKDIR}/Template-Toolkit-${PV}"

inherit cpan

FILES_${PN}-doc = "${PERLLIBDIRS}/*.pod"
FILES_${PN} = "${PERLLIBDIRS}"
FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/Template/Stash/XS/.debug/"