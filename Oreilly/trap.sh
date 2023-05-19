#!/bin/bash
# Trapping Signals in Shell Scripts
trap "echo int" SIGINT
trap "echo exiting" SIGEXIT