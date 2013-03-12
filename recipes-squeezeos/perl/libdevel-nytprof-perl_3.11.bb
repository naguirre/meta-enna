DESCRIPTION = "Devel::NYTProf - Powerful feature-rich perl source code profiler"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r15"
DEPENDS = "zlib"
LIC_FILES_CHKSUM = "file://README;md5=085e71f9f61bdf7057d5621c575bcf16"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TI/TIMB/Devel-NYTProf-${PV}.tar.gz \
	file://libdevel-nytprof-perl-Makefile.PL.patch;patch=1"

SRC_URI[md5sum] = "d67f14d336a80bd820558e90dff1b63e"
SRC_URI[sha256sum] = "a7060bc47432d5d8da26169eecb1b4a6a632f4870b14b0bd3fb6c2a34b5cf45d"

S = "${WORKDIR}/Devel-NYTProf-${PV}"

inherit cpan

export INCLUDE = "${STAGING_LIBDIR}/../include"

FILES_${PN} = "${PERLLIBDIRS}/auto/Devel/NYTProf/NYTProf.so \
               ${PERLLIBDIRS}/Devel/NYTProf.pm \
               ${PERLLIBDIRS}/Devel/NYTProf/*.pm"
