require connman.inc

inherit systemd

# 1.7 tag
SRCREV = "28004f887ab2dd8b156cfcc6cfc3f5ff3d6d96ba"
SRC_URI  = "git://git.kernel.org/pub/scm/network/connman/connman.git"

S = "${WORKDIR}/git"
PR = "r0"

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE_${PN}-systemd = "connman.service"

