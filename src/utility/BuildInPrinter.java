package utility;

import java.io.PrintStream;

public class BuildInPrinter {
    PrintStream out;
    public BuildInPrinter(PrintStream out){
        this.out=out;
    }

    public void print(){
        out.print("""
                	.file	"build_in.c"
                	.option nopic
                	.attribute arch, "rv32i2p0"
                	.attribute unaligned_access, 0
                	.attribute stack_align, 16
                	.text
                	.globl	__mulsi3
                	.align	2
                	.globl	__MALLOC_ARRAY_MUL
                	.type	__MALLOC_ARRAY_MUL, @function
                __MALLOC_ARRAY_MUL:
                	lw	a4,0(a2)
                	addi	sp,sp,-160
                	sw	ra,156(sp)
                	sw	s0,152(sp)
                	sw	s1,148(sp)
                	sw	s2,144(sp)
                	sw	s3,140(sp)
                	sw	s4,136(sp)
                	sw	s5,132(sp)
                	sw	s6,128(sp)
                	sw	s7,124(sp)
                	sw	s8,120(sp)
                	sw	s9,116(sp)
                	sw	s10,112(sp)
                	sw	s11,108(sp)
                	beq	a4,zero,.L42
                	li	a3,1
                	mv	s8,a2
                	mv	s6,a0
                	mv	s10,a1
                	beq	a1,a3,.L66
                	ble	a1,a3,.L1
                	addi	a0,a4,1
                	slli	a0,a0,2
                	call	malloc
                	lw	a3,0(s8)
                	addi	a5,a0,4
                	sw	a5,92(sp)
                	sw	a3,0(a0)
                	ble	a3,zero,.L1
                	addi	s9,s10,-9
                	sw	a5,68(sp)
                	mv	a5,s9
                	lw	a4,4(s8)
                	mv	s9,s10
                	sw	zero,64(sp)
                	mv	s10,s8
                	mv	s11,s6
                	mv	s8,a5
                .L29:
                	beq	a4,zero,.L43
                	li	a5,2
                	beq	s9,a5,.L67
                	addi	a0,a4,1
                	slli	a0,a0,2
                	call	malloc
                	lw	a4,4(s10)
                	addi	a5,a0,4
                	sw	a5,72(sp)
                	sw	a4,0(a0)
                	ble	a4,zero,.L68
                	lw	a1,8(s10)
                	addi	s6,s10,36
                	sw	a5,56(sp)
                	mv	a5,s8
                	sw	zero,52(sp)
                	mv	s8,s6
                	mv	s6,a5
                .L28:
                	beq	a1,zero,.L44
                	li	a5,3
                	beq	s9,a5,.L69
                	addi	a1,a1,1
                	slli	a0,a1,2
                	call	malloc
                	lw	a1,8(s10)
                	addi	a5,a0,4
                	sw	a5,60(sp)
                	sw	a1,0(a0)
                	ble	a1,zero,.L70
                	mv	a4,a5
                	sw	a4,44(sp)
                	mv	a4,s10
                	lw	a5,12(s10)
                	sw	zero,40(sp)
                	mv	s10,s9
                	mv	s9,a4
                .L27:
                	beq	a5,zero,.L45
                	li	a4,4
                	beq	s10,a4,.L71
                	addi	a0,a5,1
                	slli	a0,a0,2
                	call	malloc
                	lw	a5,12(s9)
                	addi	a4,a0,4
                	sw	a4,48(sp)
                	sw	a5,0(a0)
                	ble	a5,zero,.L72
                	lw	a1,16(s9)
                	sw	a4,32(sp)
                	mv	a4,s10
                	sw	zero,28(sp)
                	mv	s10,s11
                	mv	s7,s6
                	mv	s11,a4
                .L26:
                	beq	a1,zero,.L46
                	li	a5,5
                	beq	s11,a5,.L73
                	addi	a1,a1,1
                	slli	a0,a1,2
                	call	malloc
                	lw	a1,16(s9)
                	addi	a5,a0,4
                	sw	a5,36(sp)
                	sw	a1,0(a0)
                	ble	a1,zero,.L74
                	mv	a4,a5
                	lw	a5,20(s9)
                	sw	a4,20(sp)
                	sw	zero,16(sp)
                	mv	s6,s8
                .L25:
                	beq	a5,zero,.L47
                	li	a4,6
                	beq	s11,a4,.L75
                	addi	a0,a5,1
                	slli	a0,a0,2
                	call	malloc
                	lw	a5,20(s9)
                	addi	a4,a0,4
                	sw	a4,24(sp)
                	sw	a5,0(a0)
                	ble	a5,zero,.L64
                	lw	a1,24(s9)
                	mv	s5,a4
                	li	s8,0
                .L24:
                	beq	a1,zero,.L48
                	li	a5,7
                	beq	s11,a5,.L76
                	addi	a1,a1,1
                	slli	a0,a1,2
                	call	malloc
                	lw	a1,24(s9)
                	addi	a5,a0,4
                	sw	a5,12(sp)
                	sw	a1,0(a0)
                	ble	a1,zero,.L77
                	mv	s3,a5
                	lw	a5,28(s9)
                	li	s2,0
                	sw	s8,84(sp)
                	sw	s5,88(sp)
                .L23:
                	beq	a5,zero,.L49
                	li	a4,8
                	beq	s11,a4,.L78
                	addi	a0,a5,1
                	slli	a0,a0,2
                	call	malloc
                	lw	a5,28(s9)
                	sw	a0,76(sp)
                	addi	s5,a0,4
                	sw	a5,0(a0)
                	ble	a5,zero,.L63
                	lw	a1,32(s9)
                	sw	s2,80(sp)
                	mv	s4,s5
                	li	s0,0
                	beq	a1,zero,.L18
                .L82:
                	li	a5,9
                	beq	s11,a5,.L79
                	addi	a1,a1,1
                	slli	a0,a1,2
                	call	malloc
                	lw	a1,32(s9)
                	addi	s1,a0,4
                	mv	s2,s1
                	sw	a1,0(a0)
                	li	s8,0
                	ble	a1,zero,.L80
                .L21:
                	mv	a2,s6
                	mv	a1,s7
                	mv	a0,s10
                	call	__MALLOC_ARRAY_MUL
                	lw	a5,32(s9)
                	sw	a0,0(s2)
                	addi	s8,s8,1
                	addi	s2,s2,4
                	blt	s8,a5,.L21
                	mv	a1,a5
                	lw	a5,28(s9)
                .L20:
                	sw	s1,0(s4)
                	addi	s0,s0,1
                	bge	s0,a5,.L81
                	addi	s4,s4,4
                	bne	a1,zero,.L82
                .L18:
                	lw	a4,76(sp)
                	addi	s0,s0,1
                	slli	a0,s0,2
                	sw	zero,0(s4)
                	lw	s2,80(sp)
                	add	s1,a4,a0
                	ble	a5,s0,.L63
                .L22:
                	sw	zero,4(s1)
                	addi	s0,s0,1
                	addi	s1,s1,4
                	blt	s0,a5,.L22
                .L63:
                	lw	a1,24(s9)
                .L16:
                	sw	s5,0(s3)
                	addi	s2,s2,1
                	addi	s3,s3,4
                	blt	s2,a1,.L23
                	lw	s8,84(sp)
                	lw	s5,88(sp)
                	lw	a5,20(s9)
                .L14:
                	lw	a4,12(sp)
                	addi	s8,s8,1
                	addi	s5,s5,4
                	sw	a4,-4(s5)
                	blt	s8,a5,.L24
                .L64:
                	lw	a1,16(s9)
                .L12:
                	lw	a4,20(sp)
                	lw	a3,24(sp)
                	addi	a4,a4,4
                	sw	a3,-4(a4)
                	lw	a3,16(sp)
                	sw	a4,20(sp)
                	addi	a3,a3,1
                	sw	a3,16(sp)
                	blt	a3,a1,.L25
                	lw	a5,12(s9)
                	mv	s8,s6
                .L10:
                	lw	a4,32(sp)
                	lw	a3,36(sp)
                	addi	a4,a4,4
                	sw	a3,-4(a4)
                	lw	a3,28(sp)
                	sw	a4,32(sp)
                	addi	a3,a3,1
                	sw	a3,28(sp)
                	blt	a3,a5,.L26
                	lw	a1,8(s9)
                	mv	a4,s11
                	mv	s6,s7
                	mv	s11,s10
                	mv	s10,a4
                .L8:
                	lw	a4,44(sp)
                	lw	a3,48(sp)
                	addi	a4,a4,4
                	sw	a3,-4(a4)
                	lw	a3,40(sp)
                	sw	a4,44(sp)
                	addi	a3,a3,1
                	sw	a3,40(sp)
                	blt	a3,a1,.L27
                	mv	a5,s9
                	lw	a4,4(a5)
                	mv	s9,s10
                	mv	s10,a5
                .L6:
                	lw	a5,56(sp)
                	lw	a3,60(sp)
                	addi	a5,a5,4
                	sw	a3,-4(a5)
                	lw	a3,52(sp)
                	sw	a5,56(sp)
                	addi	a3,a3,1
                	sw	a3,52(sp)
                	blt	a3,a4,.L28
                	lw	a3,0(s10)
                	mv	s8,s6
                .L4:
                	lw	a5,68(sp)
                	lw	a2,72(sp)
                	addi	a5,a5,4
                	sw	a2,-4(a5)
                	lw	a2,64(sp)
                	sw	a5,68(sp)
                	addi	a2,a2,1
                	sw	a2,64(sp)
                	blt	a2,a3,.L29
                .L1:
                	lw	ra,156(sp)
                	lw	s0,152(sp)
                	lw	a0,92(sp)
                	lw	s1,148(sp)
                	lw	s2,144(sp)
                	lw	s3,140(sp)
                	lw	s4,136(sp)
                	lw	s5,132(sp)
                	lw	s6,128(sp)
                	lw	s7,124(sp)
                	lw	s8,120(sp)
                	lw	s9,116(sp)
                	lw	s10,112(sp)
                	lw	s11,108(sp)
                	addi	sp,sp,160
                	jr	ra
                .L79:
                	mv	a0,s10
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	lw	a1,32(s9)
                	lw	a5,28(s9)
                	addi	s1,a0,4
                	sw	a1,0(a0)
                	j	.L20
                .L49:
                	li	s5,0
                	j	.L16
                .L78:
                	mv	a1,a5
                	mv	a0,s10
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	lw	a5,28(s9)
                	lw	a1,24(s9)
                	addi	s5,a0,4
                	sw	a5,0(a0)
                	j	.L16
                .L48:
                	sw	zero,12(sp)
                	j	.L14
                .L76:
                	mv	a0,s10
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	lw	a1,24(s9)
                	addi	a4,a0,4
                	lw	a5,20(s9)
                	sw	a4,12(sp)
                	sw	a1,0(a0)
                	j	.L14
                .L47:
                	sw	zero,24(sp)
                	j	.L12
                .L75:
                	mv	a1,a5
                	mv	a0,s10
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	lw	a5,20(s9)
                	addi	a4,a0,4
                	lw	a1,16(s9)
                	sw	a4,24(sp)
                	sw	a5,0(a0)
                	j	.L12
                .L46:
                	sw	zero,36(sp)
                	j	.L10
                .L73:
                	mv	a0,s10
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	lw	a1,16(s9)
                	addi	a4,a0,4
                	lw	a5,12(s9)
                	sw	a4,36(sp)
                	sw	a1,0(a0)
                	j	.L10
                .L80:
                	lw	a5,28(s9)
                	j	.L20
                .L45:
                	sw	zero,48(sp)
                	j	.L8
                .L71:
                	mv	a1,a5
                	mv	a0,s11
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	lw	a5,12(s9)
                	addi	a4,a0,4
                	lw	a1,8(s9)
                	sw	a4,48(sp)
                	sw	a5,0(a0)
                	j	.L8
                .L44:
                	sw	zero,60(sp)
                	j	.L6
                .L69:
                	mv	a0,s11
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	lw	a1,8(s10)
                	addi	a5,a0,4
                	lw	a4,4(s10)
                	sw	a5,60(sp)
                	sw	a1,0(a0)
                	j	.L6
                .L77:
                	lw	a5,20(s9)
                	j	.L14
                .L43:
                	sw	zero,72(sp)
                	j	.L4
                .L67:
                	mv	a1,a4
                	mv	a0,s11
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	lw	a4,4(s10)
                	addi	a5,a0,4
                	lw	a3,0(s10)
                	sw	a5,72(sp)
                	sw	a4,0(a0)
                	j	.L4
                .L42:
                	sw	zero,92(sp)
                	j	.L1
                .L66:
                	mv	a1,a0
                	mv	a0,a4
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	lw	a5,0(s8)
                	addi	a4,a0,4
                	sw	a4,92(sp)
                	sw	a5,0(a0)
                	j	.L1
                .L74:
                	lw	a5,12(s9)
                	j	.L10
                .L72:
                	lw	a1,8(s9)
                	j	.L8
                .L70:
                	lw	a4,4(s10)
                	j	.L6
                .L68:
                	lw	a3,0(s10)
                	j	.L4
                .L81:
                	lw	s2,80(sp)
                	j	.L63
                	.size	__MALLOC_ARRAY_MUL, .-__MALLOC_ARRAY_MUL
                	.align	2
                	.globl	__MALLOC_ARRAY
                	.type	__MALLOC_ARRAY, @function
                __MALLOC_ARRAY:
                	addi	sp,sp,-16
                	sw	ra,12(sp)
                	sw	s0,8(sp)
                	mv	s0,a1
                	call	__mulsi3
                	addi	a0,a0,4
                	call	malloc
                	sw	s0,0(a0)
                	lw	ra,12(sp)
                	lw	s0,8(sp)
                	addi	a0,a0,4
                	addi	sp,sp,16
                	jr	ra
                	.size	__MALLOC_ARRAY, .-__MALLOC_ARRAY
                	.align	2
                	.globl	__MALLOC
                	.type	__MALLOC, @function
                __MALLOC:
                	tail	malloc
                	.size	__MALLOC, .-__MALLOC
                	.section	.rodata.str1.4,"aMS",@progbits,1
                	.align	2
                .LC0:
                	.string	"%s"
                	.text
                	.align	2
                	.globl	__PRINT
                	.type	__PRINT, @function
                __PRINT:
                	mv	a1,a0
                	lui	a0,%hi(.LC0)
                	addi	a0,a0,%lo(.LC0)
                	tail	printf
                	.size	__PRINT, .-__PRINT
                	.align	2
                	.globl	__PRINTLN
                	.type	__PRINTLN, @function
                __PRINTLN:
                	tail	puts
                	.size	__PRINTLN, .-__PRINTLN
                	.section	.rodata.str1.4
                	.align	2
                .LC1:
                	.string	"%d"
                	.text
                	.align	2
                	.globl	__PRINT_INT
                	.type	__PRINT_INT, @function
                __PRINT_INT:
                	mv	a1,a0
                	lui	a0,%hi(.LC1)
                	addi	a0,a0,%lo(.LC1)
                	tail	printf
                	.size	__PRINT_INT, .-__PRINT_INT
                	.section	.rodata.str1.4
                	.align	2
                .LC2:
                	.string	"%d\\n"
                	.text
                	.align	2
                	.globl	__PRINTLN_INT
                	.type	__PRINTLN_INT, @function
                __PRINTLN_INT:
                	mv	a1,a0
                	lui	a0,%hi(.LC2)
                	addi	a0,a0,%lo(.LC2)
                	tail	printf
                	.size	__PRINTLN_INT, .-__PRINTLN_INT
                	.align	2
                	.globl	__GET_SIZE
                	.type	__GET_SIZE, @function
                __GET_SIZE:
                	lw	a0,0(a0)
                	ret
                	.size	__GET_SIZE, .-__GET_SIZE
                	.section	.rodata.str1.4
                	.align	2
                .LC3:
                	.string	"%255s"
                	.text
                	.align	2
                	.globl	__GET_STRING
                	.type	__GET_STRING, @function
                __GET_STRING:
                	addi	sp,sp,-16
                	li	a0,260
                	sw	ra,12(sp)
                	sw	s0,8(sp)
                	sw	s1,4(sp)
                	call	malloc
                	addi	s1,a0,4
                	mv	s0,a0
                	lui	a0,%hi(.LC3)
                	mv	a1,s1
                	addi	a0,a0,%lo(.LC3)
                	call	scanf
                	mv	a0,s1
                	call	strlen
                	sw	a0,0(s0)
                	lw	ra,12(sp)
                	lw	s0,8(sp)
                	mv	a0,s1
                	lw	s1,4(sp)
                	addi	sp,sp,16
                	jr	ra
                	.size	__GET_STRING, .-__GET_STRING
                	.align	2
                	.globl	__GET_INT
                	.type	__GET_INT, @function
                __GET_INT:
                	addi	sp,sp,-32
                	lui	a0,%hi(.LC1)
                	addi	a1,sp,12
                	addi	a0,a0,%lo(.LC1)
                	sw	ra,28(sp)
                	call	scanf
                	lw	ra,28(sp)
                	lw	a0,12(sp)
                	addi	sp,sp,32
                	jr	ra
                	.size	__GET_INT, .-__GET_INT
                	.align	2
                	.globl	__TO_STRING
                	.type	__TO_STRING, @function
                __TO_STRING:
                	addi	sp,sp,-16
                	sw	s1,4(sp)
                	mv	s1,a0
                	li	a0,260
                	sw	ra,12(sp)
                	sw	s0,8(sp)
                	sw	s2,0(sp)
                	call	malloc
                	addi	s2,a0,4
                	lui	a1,%hi(.LC1)
                	mv	s0,a0
                	mv	a2,s1
                	mv	a0,s2
                	addi	a1,a1,%lo(.LC1)
                	call	sprintf
                	sw	a0,0(s0)
                	lw	ra,12(sp)
                	lw	s0,8(sp)
                	lw	s1,4(sp)
                	mv	a0,s2
                	lw	s2,0(sp)
                	addi	sp,sp,16
                	jr	ra
                	.size	__TO_STRING, .-__TO_STRING
                	.align	2
                	.globl	__STRING_ADD
                	.type	__STRING_ADD, @function
                __STRING_ADD:
                	addi	sp,sp,-32
                	sw	ra,28(sp)
                	sw	s0,24(sp)
                	sw	s1,20(sp)
                	sw	s2,16(sp)
                	sw	s3,12(sp)
                	sw	s4,8(sp)
                	sw	s5,4(sp)
                	mv	s1,a1
                	mv	s4,a0
                	call	strlen
                	mv	s0,a0
                	mv	a0,s1
                	call	strlen
                	add	s5,s0,a0
                	mv	s2,a0
                	addi	a0,s5,5
                	call	malloc
                	mv	a5,a0
                	addi	s3,a0,4
                	mv	a2,s0
                	mv	a1,s4
                	sw	s5,0(a5)
                	mv	a0,s3
                	call	memcpy
                	add	a0,s3,s0
                	addi	a2,s2,1
                	mv	a1,s1
                	call	memcpy
                	lw	ra,28(sp)
                	lw	s0,24(sp)
                	lw	s1,20(sp)
                	lw	s2,16(sp)
                	lw	s4,8(sp)
                	lw	s5,4(sp)
                	mv	a0,s3
                	lw	s3,12(sp)
                	addi	sp,sp,32
                	jr	ra
                	.size	__STRING_ADD, .-__STRING_ADD
                	.align	2
                	.globl	__STRING_EQUAL
                	.type	__STRING_EQUAL, @function
                __STRING_EQUAL:
                	addi	sp,sp,-16
                	sw	ra,12(sp)
                	call	strcmp
                	lw	ra,12(sp)
                	seqz	a0,a0
                	addi	sp,sp,16
                	jr	ra
                	.size	__STRING_EQUAL, .-__STRING_EQUAL
                	.align	2
                	.globl	__STRING_NOT_EQUAL
                	.type	__STRING_NOT_EQUAL, @function
                __STRING_NOT_EQUAL:
                	addi	sp,sp,-16
                	sw	ra,12(sp)
                	call	strcmp
                	lw	ra,12(sp)
                	snez	a0,a0
                	addi	sp,sp,16
                	jr	ra
                	.size	__STRING_NOT_EQUAL, .-__STRING_NOT_EQUAL
                	.align	2
                	.globl	__STRING_LESS
                	.type	__STRING_LESS, @function
                __STRING_LESS:
                	addi	sp,sp,-16
                	sw	ra,12(sp)
                	call	strcmp
                	lw	ra,12(sp)
                	srli	a0,a0,31
                	addi	sp,sp,16
                	jr	ra
                	.size	__STRING_LESS, .-__STRING_LESS
                	.align	2
                	.globl	__STRING_GREATER
                	.type	__STRING_GREATER, @function
                __STRING_GREATER:
                	addi	sp,sp,-16
                	sw	ra,12(sp)
                	call	strcmp
                	lw	ra,12(sp)
                	sgt	a0,a0,zero
                	addi	sp,sp,16
                	jr	ra
                	.size	__STRING_GREATER, .-__STRING_GREATER
                	.align	2
                	.globl	__STRING_LESS_EQUAL
                	.type	__STRING_LESS_EQUAL, @function
                __STRING_LESS_EQUAL:
                	addi	sp,sp,-16
                	sw	ra,12(sp)
                	call	strcmp
                	lw	ra,12(sp)
                	slti	a0,a0,1
                	addi	sp,sp,16
                	jr	ra
                	.size	__STRING_LESS_EQUAL, .-__STRING_LESS_EQUAL
                	.align	2
                	.globl	__STRING_GREATER_EQUAL
                	.type	__STRING_GREATER_EQUAL, @function
                __STRING_GREATER_EQUAL:
                	addi	sp,sp,-16
                	sw	ra,12(sp)
                	call	strcmp
                	lw	ra,12(sp)
                	not	a0,a0
                	srli	a0,a0,31
                	addi	sp,sp,16
                	jr	ra
                	.size	__STRING_GREATER_EQUAL, .-__STRING_GREATER_EQUAL
                	.align	2
                	.globl	__STRING_SUBSTRING
                	.type	__STRING_SUBSTRING, @function
                __STRING_SUBSTRING:
                	addi	sp,sp,-16
                	sw	s0,8(sp)
                	sub	s0,a2,a1
                	sw	s2,0(sp)
                	mv	s2,a0
                	addi	a0,s0,5
                	sw	ra,12(sp)
                	sw	s1,4(sp)
                	mv	s1,a1
                	call	malloc
                	mv	a5,a0
                	addi	a4,a0,4
                	add	a1,s2,s1
                	mv	a2,s0
                	sw	s0,0(a5)
                	mv	a0,a4
                	call	memcpy
                	add	s0,a0,s0
                	sb	zero,0(s0)
                	lw	ra,12(sp)
                	lw	s0,8(sp)
                	lw	s1,4(sp)
                	lw	s2,0(sp)
                	addi	sp,sp,16
                	jr	ra
                	.size	__STRING_SUBSTRING, .-__STRING_SUBSTRING
                	.align	2
                	.globl	__STRING_PARSE_INT
                	.type	__STRING_PARSE_INT, @function
                __STRING_PARSE_INT:
                	lbu	a4,0(a0)
                	mv	a3,a0
                	li	a0,9
                	addi	a5,a4,-48
                	andi	a5,a5,0xff
                	li	a6,0
                	li	a1,45
                	li	a2,9
                	bgtu	a5,a0,.L114
                	j	.L115
                .L117:
                	bne	a4,a1,.L116
                	li	a6,1
                .L116:
                	lbu	a4,0(a3)
                	addi	a5,a4,-48
                	andi	a5,a5,0xff
                	bleu	a5,a2,.L115
                .L114:
                	addi	a3,a3,1
                	bne	a4,zero,.L117
                	li	a0,0
                .L118:
                	beq	a6,zero,.L113
                	neg	a0,a0
                .L113:
                	ret
                .L115:
                	li	a0,0
                	li	a1,9
                .L119:
                	slli	a5,a0,2
                	add	a5,a5,a0
                	slli	a5,a5,1
                	addi	a5,a5,-48
                	addi	a3,a3,1
                	add	a0,a4,a5
                	lbu	a4,0(a3)
                	addi	a2,a4,-48
                	andi	a2,a2,0xff
                	bleu	a2,a1,.L119
                	j	.L118
                	.size	__STRING_PARSE_INT, .-__STRING_PARSE_INT
                	.align	2
                	.globl	__STRING_ORD
                	.type	__STRING_ORD, @function
                __STRING_ORD:
                	add	a0,a0,a1
                	lbu	a0,0(a0)
                	ret
                	.size	__STRING_ORD, .-__STRING_ORD
                	.align	2
                	.globl	__STRING_LENGTH
                	.type	__STRING_LENGTH, @function
                __STRING_LENGTH:
                	tail	strlen
                	.size	__STRING_LENGTH, .-__STRING_LENGTH
                	.section	.text.startup,"ax",@progbits
                	.align	2
                	.ident	"GCC: (GNU) 10.1.0"
                """);
    }
}
