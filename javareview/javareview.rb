require "AssessmentBase.rb"

module Javareview 
  include AssessmentBase

  def assessmentInitialize(course)
    super("JavaReview",course)
    @problems = []
  end

end
