require connman.inc

inherit systemd

SRC_URI  = "http://www.kernel.org/pub/linux/network/connman/connman-${PV}.tar.xz"

S = "${WORKDIR}/connman-${PV}"
PR = "r1"

SRC_URI[md5sum] = "6386d04ccbfd66c68e94ae7a8859a3a4"
SRC_URI[sha256sum] = "8ca8a2ab5477b05821ee3e535320fce55409f7615313ccb785e672660b452314"

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE_${PN}-systemd = "connman.service"

