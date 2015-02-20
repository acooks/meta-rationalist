SUMMARY = "Config for Rationali.st JitterTrap."
SECTION = "base"
LICENSE = "CLOSED"
RDEPENDS_${PN} = "initscripts"
PR = "r0"

SRC_URI = "file://systemd/network/br0.netdev \
           file://systemd/network/br0.network \
           file://systemd/network/enp2s0.link \
           file://systemd/network/enp2s0.network \
           file://systemd/network/enp3s0.link \
           file://systemd/network/enp3s0.network \
           file://systemd/network/mgmt.link \
           file://systemd/network/mgmt.network"

CONFFILES_${PN} += "${sysconfdir}/systemd/system/serial-getty@ttyS0.service"

do_install () {
	install -d ${D}${sysconfdir}/systemd/network
	install -m 644 ${WORKDIR}/systemd/network/* ${D}${sysconfdir}/systemd/network/
#	install -d ${D}${sysconfdir}/systemd/system
#	install -m 644 ${WORKDIR}/systemd/system/* ${D}${sysconfdir}/systemd/system/

}

