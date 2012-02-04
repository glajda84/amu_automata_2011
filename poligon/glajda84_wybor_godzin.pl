#!/usr/bin/perl
# -*- coding: utf-8 -*-

my @godziny;

for ($i = 0; $i <= 23; $i = $i + 1)
{
	$godziny[$i] = 0;
}

while (my $linia = <>)
{
	@tokeny = split(/\s+/, $linia);
	foreach $token (@tokeny)
	{
		if ($token =~ /(([1]?[0-9])|([2][0-3]))[:|.]([0-5][0-9])?/)
		{
			$token =~ m/(([1]?[0-9])|([2][0-3]))[:|.]([0-5][0-9])?/;
			$godzina = $1;
			$godziny[$godzina] = $godziny[$godzina] + 1
		}
	}
}

for ($i = 0; $i <= 23; $i = $i + 1)
{
	if ($godziny[$i] != 0)
	{
		print $godziny[$i]." ".$i."\n";
	}
}


