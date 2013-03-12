DESCRIPTION = "Image::Scale - Fast, high-quality fixed-point image resizing"
SECTION = "libs"
LICENSE = "GPL"
PR = "r8"

LIC_FILES_CHKSUM = "file://README;md5=bcb6224bdd4fb35b1dbd893716406cd4"

# XXX This requires these libraries to be installed at /usr/lib on the build machine
# Need Makefile.PL changes to support cross-compilation library location
DEPENDS = "jpeg libpng giflib"

ARM_INSTRUCTION_SET = "arm"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AG/AGRUNDMA/Image-Scale-${PV}.tar.gz"

SRC_URI[md5sum] = "60d6b1d78e229682c3565ee12a171cb4"
SRC_URI[sha256sum] = "e2dcc90b9954a43dafc7f61bc6dc472382eb719b1046247da5a93cfdd7c3b3e0"

S = "${WORKDIR}/Image-Scale-${PV}"

inherit cpan

export INCLUDE = "${STAGING_INCDIR}"

FILES_${PN} = "${PERLLIBDIRS}"
FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/Image/Scale/.debug/"