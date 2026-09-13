require "AssessmentBase.rb"

module Interfaces
  include AssessmentBase

  def assessmentInitialize(course)
    super("Interfaces",course)
    @problems = []
  end

end
