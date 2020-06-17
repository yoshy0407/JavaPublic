package com.bench.mark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


public abstract class BenchMarkMain {

	public static void main(String[] args) throws RunnerException{
		
		
		final Options options = new OptionsBuilder()
				.include("com.bench.mark.target")
				.forks(1)
				.build();
		new Runner(options).run();
	}
}
