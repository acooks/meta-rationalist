SUMMARY = "Config for Rationali.st JitterTrap on PC Engines APU1."
SECTION = "base"
LICENSE = "GPLv2"
RDEPENDS_${PN} = "initscripts apu1-serial-number"
PR = "r0"
COMPATIBLE_MACHINE = "mousetrap_hw"
RPROVIDES_${PN} = "trap-machine-config"

RRECOMMENDS_${PN}-dev += "valgrind gdb latencytop ethtool"

SRC_URI = "file://systemd/network/br0.netdev \
           file://systemd/network/100-mgmt.link \
           file://systemd/network/101-port1.link \
           file://systemd/network/102-port2.link \
           file://systemd/network/br0.network \
           file://systemd/network/port1.network \
           file://systemd/network/port2.network \
           file://systemd/network/mgmt.network"

CONFFILES_${PN} += "${sysconfdir}/systemd/system/serial-getty@ttyS0.service"

do_install () {
	install -d ${D}${sysconfdir}/systemd/network
	install -m 644 ${WORKDIR}/systemd/network/* ${D}${sysconfdir}/systemd/network/
#	install -d ${D}${sysconfdir}/systemd/system
#	install -m 644 ${WORKDIR}/systemd/system/* ${D}${sysconfdir}/systemd/system/

}

