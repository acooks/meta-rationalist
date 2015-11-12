SUMMARY = "Firmware files for use with Linux kernel"
SECTION = "kernel"


LICENSE = "WHENCE"
LIC_FILES_CHKSUM = "file://WHENCE;md5=e896f2f5d42bb996b9213261bcb815ae"

# Set NO_GENERIC_LICENSE so that the license file will be copied from
# fetched source
NO_GENERIC_LICENSE[WHENCE] = "WHENCE"

SRCREV = "75cc3ef8ba6712fd72c073b17a790282136cc743"
PE = "1"
PV = "0.0+git${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git"

S = "${WORKDIR}/git"

inherit allarch update-alternatives
#inherit allarch

CLEANBROKEN = "1"

do_compile() {
	:
}

do_install() {
	:
}

