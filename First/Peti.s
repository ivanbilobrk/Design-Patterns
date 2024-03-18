	.file	"Peti.cpp"
	.intel_syntax noprefix
	.text
	.local	_ZStL8__ioinit
	.comm	_ZStL8__ioinit,1,1
	.section	.text._ZN1D4prvaEv,"axG",@progbits,_ZN1D4prvaEv,comdat
	.align 2
	.weak	_ZN1D4prvaEv
	.type	_ZN1D4prvaEv, @function
_ZN1D4prvaEv:
.LFB1731:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	mov	QWORD PTR -8[rbp], rdi
	mov	eax, 42
	pop	rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1731:
	.size	_ZN1D4prvaEv, .-_ZN1D4prvaEv
	.section	.text._ZN1D5drugaEi,"axG",@progbits,_ZN1D5drugaEi,comdat
	.align 2
	.weak	_ZN1D5drugaEi
	.type	_ZN1D5drugaEi, @function
_ZN1D5drugaEi:
.LFB1732:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	QWORD PTR -8[rbp], rdi
	mov	DWORD PTR -12[rbp], esi
	mov	rax, QWORD PTR -8[rbp]
	mov	rax, QWORD PTR [rax]
	mov	rdx, QWORD PTR [rax]
	mov	rax, QWORD PTR -8[rbp]
	mov	rdi, rax
	call	rdx
	mov	edx, DWORD PTR -12[rbp]
	add	eax, edx
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1732:
	.size	_ZN1D5drugaEi, .-_ZN1D5drugaEi
	.section	.rodata
.LC0:
	.string	"Result of first call is "
.LC1:
	.string	", result of second call is "
.LC2:
	.string	"\n"
	.text
	.globl	_Z8testFuncP1B
	.type	_Z8testFuncP1B, @function
_Z8testFuncP1B:
.LFB1733:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 32
	mov	QWORD PTR -24[rbp], rdi
	mov	rax, QWORD PTR -24[rbp]
	mov	rax, QWORD PTR [rax]
	mov	QWORD PTR -8[rbp], rax
	mov	rax, QWORD PTR -8[rbp]
	mov	rax, QWORD PTR [rax]
	mov	rdx, rax
	mov	rax, QWORD PTR -24[rbp]
	mov	rdi, rax
	call	rdx
	mov	DWORD PTR -16[rbp], eax
	mov	rax, QWORD PTR -8[rbp]
	add	rax, 8
	mov	rax, QWORD PTR [rax]
	mov	rdx, rax
	mov	rax, QWORD PTR -24[rbp]
	mov	esi, 16
	mov	rdi, rax
	call	rdx
	mov	DWORD PTR -12[rbp], eax
	lea	rax, .LC0[rip]
	mov	rsi, rax
	lea	rax, _ZSt4cout[rip]
	mov	rdi, rax
	call	_ZStlsISt11char_traitsIcEERSt13basic_ostreamIcT_ES5_PKc@PLT
	mov	rdx, rax
	mov	eax, DWORD PTR -16[rbp]
	mov	esi, eax
	mov	rdi, rdx
	call	_ZNSolsEi@PLT
	mov	rdx, rax
	lea	rax, .LC1[rip]
	mov	rsi, rax
	mov	rdi, rdx
	call	_ZStlsISt11char_traitsIcEERSt13basic_ostreamIcT_ES5_PKc@PLT
	mov	rdx, rax
	mov	eax, DWORD PTR -12[rbp]
	mov	esi, eax
	mov	rdi, rdx
	call	_ZNSolsEi@PLT
	mov	rdx, rax
	lea	rax, .LC2[rip]
	mov	rsi, rax
	mov	rdi, rdx
	call	_ZStlsISt11char_traitsIcEERSt13basic_ostreamIcT_ES5_PKc@PLT
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1733:
	.size	_Z8testFuncP1B, .-_Z8testFuncP1B
	.section	.text._ZN1BC2Ev,"axG",@progbits,_ZN1BC5Ev,comdat
	.align 2
	.weak	_ZN1BC2Ev
	.type	_ZN1BC2Ev, @function
_ZN1BC2Ev:
.LFB1737:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	mov	QWORD PTR -8[rbp], rdi
	lea	rdx, _ZTV1B[rip+16]
	mov	rax, QWORD PTR -8[rbp]
	mov	QWORD PTR [rax], rdx
	nop
	pop	rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1737:
	.size	_ZN1BC2Ev, .-_ZN1BC2Ev
	.weak	_ZN1BC1Ev
	.set	_ZN1BC1Ev,_ZN1BC2Ev
	.section	.text._ZN1DC2Ev,"axG",@progbits,_ZN1DC5Ev,comdat
	.align 2
	.weak	_ZN1DC2Ev
	.type	_ZN1DC2Ev, @function
_ZN1DC2Ev:
.LFB1739:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	QWORD PTR -8[rbp], rdi
	mov	rax, QWORD PTR -8[rbp]
	mov	rdi, rax
	call	_ZN1BC2Ev
	lea	rdx, _ZTV1D[rip+16]
	mov	rax, QWORD PTR -8[rbp]
	mov	QWORD PTR [rax], rdx
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1739:
	.size	_ZN1DC2Ev, .-_ZN1DC2Ev
	.weak	_ZN1DC1Ev
	.set	_ZN1DC1Ev,_ZN1DC2Ev
	.text
	.globl	main
	.type	main, @function
main:
.LFB1734:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	push	rbx
	sub	rsp, 24
	.cfi_offset 3, -24
	mov	edi, 8
	call	_Znwm@PLT
	mov	rbx, rax
	mov	rdi, rbx
	call	_ZN1DC1Ev
	mov	QWORD PTR -24[rbp], rbx
	mov	rax, QWORD PTR -24[rbp]
	mov	rdi, rax
	call	_Z8testFuncP1B
	mov	eax, 0
	mov	rbx, QWORD PTR -8[rbp]
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1734:
	.size	main, .-main
	.weak	_ZTV1D
	.section	.data.rel.ro.local._ZTV1D,"awG",@progbits,_ZTV1D,comdat
	.align 8
	.type	_ZTV1D, @object
	.size	_ZTV1D, 32
_ZTV1D:
	.quad	0
	.quad	_ZTI1D
	.quad	_ZN1D4prvaEv
	.quad	_ZN1D5drugaEi
	.weak	_ZTV1B
	.section	.data.rel.ro._ZTV1B,"awG",@progbits,_ZTV1B,comdat
	.align 8
	.type	_ZTV1B, @object
	.size	_ZTV1B, 32
_ZTV1B:
	.quad	0
	.quad	_ZTI1B
	.quad	__cxa_pure_virtual
	.quad	__cxa_pure_virtual
	.weak	_ZTI1D
	.section	.data.rel.ro._ZTI1D,"awG",@progbits,_ZTI1D,comdat
	.align 8
	.type	_ZTI1D, @object
	.size	_ZTI1D, 24
_ZTI1D:
	.quad	_ZTVN10__cxxabiv120__si_class_type_infoE+16
	.quad	_ZTS1D
	.quad	_ZTI1B
	.weak	_ZTS1D
	.section	.rodata._ZTS1D,"aG",@progbits,_ZTS1D,comdat
	.type	_ZTS1D, @object
	.size	_ZTS1D, 3
_ZTS1D:
	.string	"1D"
	.weak	_ZTI1B
	.section	.data.rel.ro._ZTI1B,"awG",@progbits,_ZTI1B,comdat
	.align 8
	.type	_ZTI1B, @object
	.size	_ZTI1B, 16
_ZTI1B:
	.quad	_ZTVN10__cxxabiv117__class_type_infoE+16
	.quad	_ZTS1B
	.weak	_ZTS1B
	.section	.rodata._ZTS1B,"aG",@progbits,_ZTS1B,comdat
	.type	_ZTS1B, @object
	.size	_ZTS1B, 3
_ZTS1B:
	.string	"1B"
	.text
	.type	_Z41__static_initialization_and_destruction_0ii, @function
_Z41__static_initialization_and_destruction_0ii:
.LFB2238:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	DWORD PTR -4[rbp], edi
	mov	DWORD PTR -8[rbp], esi
	cmp	DWORD PTR -4[rbp], 1
	jne	.L12
	cmp	DWORD PTR -8[rbp], 65535
	jne	.L12
	lea	rax, _ZStL8__ioinit[rip]
	mov	rdi, rax
	call	_ZNSt8ios_base4InitC1Ev@PLT
	lea	rax, __dso_handle[rip]
	mov	rdx, rax
	lea	rax, _ZStL8__ioinit[rip]
	mov	rsi, rax
	mov	rax, QWORD PTR _ZNSt8ios_base4InitD1Ev@GOTPCREL[rip]
	mov	rdi, rax
	call	__cxa_atexit@PLT
.L12:
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE2238:
	.size	_Z41__static_initialization_and_destruction_0ii, .-_Z41__static_initialization_and_destruction_0ii
	.type	_GLOBAL__sub_I__Z8testFuncP1B, @function
_GLOBAL__sub_I__Z8testFuncP1B:
.LFB2239:
	.cfi_startproc
	endbr64
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	mov	esi, 65535
	mov	edi, 1
	call	_Z41__static_initialization_and_destruction_0ii
	pop	rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE2239:
	.size	_GLOBAL__sub_I__Z8testFuncP1B, .-_GLOBAL__sub_I__Z8testFuncP1B
	.section	.init_array,"aw"
	.align 8
	.quad	_GLOBAL__sub_I__Z8testFuncP1B
	.weak	__cxa_pure_virtual
	.hidden	__dso_handle
	.ident	"GCC: (Ubuntu 11.3.0-1ubuntu1~22.04) 11.3.0"
	.section	.note.GNU-stack,"",@progbits
	.section	.note.gnu.property,"a"
	.align 8
	.long	1f - 0f
	.long	4f - 1f
	.long	5
0:
	.string	"GNU"
1:
	.align 8
	.long	0xc0000002
	.long	3f - 2f
2:
	.long	0x3
3:
	.align 8
4:
