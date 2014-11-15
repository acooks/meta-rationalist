SUMMARY = "A small image just capable of allowing a device to boot."

RATIONALIST_PKGS = "\
 ethtool\
 expat\
 initscripts\
 iproute2\
 iproute2-tc\
 iptables\
 kernel-base\
 kernel-module-binfmt-misc\
 kernel-module-iptable-filter\
 kernel-module-iptable-nat\
 kernel-module-ip-tables\
 kernel-module-ipt-masquerade\
 kernel-module-nf-conntrack\
 kernel-module-nf-conntrack-ipv4\
 kernel-module-nf-defrag-ipv4\
 kernel-module-nf-nat\
 kernel-module-nf-nat-ipv4\
 kernel-module-ppp-generic\
 kernel-module-pppoe\
 kernel-module-pppox\
 kernel-module-x-tables\
 kmod\
 libacl\
 libattr\
 libcap\
 libcomerr\
 libe2p\
 libext2fs\
 libgcc\
 libkmod\
 liblzma\
 libwrap\
 libx11\
 libxau\
 libxcb\
 libxdmcp\
 netbase\
 openssh\
 packagegroup-core-boot\
 pciutils\
 ppp\
 ppp-oa\
 ppp-oe\
 ppp-tools\
 run-postinsts\
 shadow\
 shadow-securetty\
 systemd\
 systemd-binfmt\
 systemd-compat-units\
 systemd-serialgetty\
 update-alternatives-opkg\
 update-rc.d\
 util-linux-agetty\
 util-linux-fsck\
 util-linux-libblkid\
 util-linux-libmount\
 util-linux-libuuid\
 util-linux-mount\
 zlib\
"

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL} ${RATIONALIST_PKGS}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"


