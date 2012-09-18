DESCRIPTION = "Network Packet Capture Library"
HOMEPAGE = "http://www.tcpdump.org/"
LICENSE = "BSD"
SECTION = "libs/network"
PR = "r2"

DEPENDS = "flex-native bison-native"

SRC_URI = "http://www.at.tcpdump.org/release/libpcap-${PV}.tar.gz \
           file://shared.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-pcap=linux"

CPPFLAGS_prepend = "-I${S} "
CFLAGS_prepend = "-I${S} "
CXXFLAGS_prepend = "-I${S} "

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cat aclocal.m4 > acinclude.m4
	fi
}
