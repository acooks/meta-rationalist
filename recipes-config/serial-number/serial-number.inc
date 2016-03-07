SUMMARY = "A tool to read the serial number and write the hostname"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRCREV = "${AUTOREV}"
PR = "r3"
PV = "${PR}+git${SRCPV}"

SRC_URI += "git:///mnt/devel/git-repos/apu-serial-number.git"

inherit package 

RDEPENDS_${PN} += " glibc "

S = "${WORKDIR}/git"

do_compile() {
   make CFLAGS_EXTRA="${CFLAGS}"
}

do_install() {
   install -d ${D}/usr/bin/
   install -m 0744 ${S}/get-serial-number ${D}/usr/bin/
}

pkg_postinst_${PN}() {
   if [ x"$D" = "x" ]; then
      # Actions to carry out on the device go here
      /usr/bin/get-serial-number -i eth0 -m ${MACHINE_MODEL} -w
   else
      exit 1
   fi
}
